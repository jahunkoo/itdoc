package connect;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Properties;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

import com.example.hanikok.R;

/**
 * Http통신으로 json형식의 데이터를 주고받을 때 사용되는 클래스
 * 로딩화면에 쓰이는 레이아웃 : connection_loading.xml
 * 
 */
public class HttpConnectionModule {

	
	public static final String GET = "GET";
	public static final String POST = "POST";
	public static final String MULTIPART_POST = "MULTIPART_POST";
	private final String NETWOEK_NOT_AVAILABLE = "network not available";
	//기본 method
	private String method = "GET";
	public DownloadTask downloadTask;
	private String parameter;
	private Context context;
	private Activity activity;
	private View loadingView;
	private File uploadFile;
	private String fileName;
	
	public HttpConnectionModule(Context context){ 
		downloadTask = new DownloadTask();
		this.context = context;
		activity = (Activity) context;
		
		//데이터 주고받을 동안 띄워질  connection_loading.xml 화면  객체화
		LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		loadingView = inflator.inflate(R.layout.connection_loading, null);
		activity.addContentView(loadingView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	} 

	
	/**
	 * 어떤 방식으로 서버와 통신할 지 정한다.
	 * @param httpMethod
	 */
	public void setMethod(String httpMethod){
		this.method = httpMethod;
	}
	
	/**
	 * 서버로 보낼 데이터가 있을 경우에 메서드를 호출한다. 
	 * @param prop
	 * @throws UnsupportedEncodingException
	 */
	public void setProperties(Properties prop) throws UnsupportedEncodingException{
		this.parameter = encodeString(prop);
	}
	/**
	 * 서버로 보낼 파일이 있을 경우에 메서드를 호출한다. 
	 * @param file
	 * @param fileName 서버에 저장될 유니크한 값을 갖는 파일명
	 */
	public void setFile(File file, String fileName){
		this.uploadFile = file;
		this.fileName = fileName;
	}
	/**
	 * 네트워크가 연결되어 있는 상태인지 확인한다.
	 * @return isConnected
	 */
	private boolean isNetworkConnection(){
		boolean isConnected = false;
		ConnectivityManager connMgr = (ConnectivityManager) 
		        context.getSystemService(Context.CONNECTIVITY_SERVICE);
		    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		    if (networkInfo != null && networkInfo.isConnected()){
		    	isConnected = true;
		    }else{
		    	isConnected = false;
		    	//display error
		    	//Toast.makeText(context, "No network connection available.", Toast.LENGTH_SHORT).show();
		    	Log.d("test","test");
		    }
		return isConnected;
	}
	
	/**
     * Implementation of AsyncTask, to fetch the data in the background away from
     * the UI thread.
     */
    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
		protected void onPreExecute() {
        	loadingView.setVisibility(View.VISIBLE);
			super.onPreExecute();
		}

		@Override
        protected String doInBackground(String... urls) {
        	
            try {
            	if(isNetworkConnection()){
            		 return loadFromNetwork(urls[0]);
            	}else{
            		return NETWOEK_NOT_AVAILABLE;
            	}
            } catch (IOException e) {
            	e.printStackTrace();
              return e.getMessage();
            }
        }

        /**
         * Uses the logging framework to display the output of the fetch
         * operation in the log fragment.
         */
        @Override
        protected void onPostExecute(String result) {
        	//connection_loading 레이아웃 GONE
        	loadingView.setVisibility(View.GONE);
        	if(result.equals("networkNotConnection")){
        		Toast.makeText(context, NETWOEK_NOT_AVAILABLE, Toast.LENGTH_SHORT).show();
        	}	
        	//Log.i(TAG, result);
        }
    }
    
    
    
    /** Initiates the fetch operation. */
    private String loadFromNetwork(String urlString) throws IOException {
        InputStream stream = null;
        String str =new String();

        try {
        	if(method.equals(GET)){
        		stream = urlConnectionByGetMethod(urlString);
        	}else if(method.equals(POST)){
        		stream = urlConnectionByPostMethod(urlString);
        	}else if(method.equals(MULTIPART_POST)){
        		stream = urlConnectionByMultiPartPostMethod(urlString);
        	}
            str = readIt(stream, 500);
       } finally {
           if (stream != null) {
               stream.close();
            }
        }
        return str;
    }

    /**
     * Given a string representation of a URL, sets up a connection and gets
     * an input stream.
     * @param targetUrl A string representation of a URL.
     * @return An InputStream retrieved from a successful HttpURLConnection.
     * @throws java.io.IOException
     */
    private InputStream urlConnectionByGetMethod(String targetUrl) throws IOException {
    	// BEGIN_INCLUDE(get_inputstream)
        URL url = new URL(targetUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000 /* milliseconds */);
        conn.setConnectTimeout(15000 /* milliseconds */);
        
        //GET방식
        conn.setRequestMethod(method);
        conn.setDoInput(true);
        
        // Start the query **************************
        conn.connect();
        InputStream stream = conn.getInputStream();
        return stream;
        // END_INCLUDE(get_inputstream)
    }
 
    private InputStream urlConnectionByPostMethod(String targetUrl) throws IOException {
    	InputStream is = null;
        URL url = new URL(targetUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000 /* milliseconds */);
        conn.setConnectTimeout(15000 /* milliseconds */);
        conn.setRequestMethod(method);
        conn.setDoOutput(true);
        conn.setDoInput(true);
            
        OutputStream os = conn.getOutputStream();
        os.write( parameter.getBytes("utf-8") );
        // 스트림의 버퍼를 비워준다.
        os.flush();
        // 스트림을 닫는다.
        os.close();
            
        // Starts the query
        conn.connect();
        int response = conn.getResponseCode();
         is = conn.getInputStream();
        
        return is;
        // END_INCLUDE(get_inputstream)
    }
    
    private final String BOUNDARY = "@****************************@";
    private final String LINE_END = "\r\n";
    private final String TWO_HYPHENS = "--";
    private InputStream urlConnectionByMultiPartPostMethod(String targetUrl) throws IOException {
    	
		InputStream is = null;
		try {
			//inputStream = new FileInputStream(fileName);  
			
			URL url = new URL(targetUrl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();   
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
			
			// write data
			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());

			//key(name),value 
			addFormField(dos, "fileName", fileName);
			
			//add File
			InputStream inputStream = new FileInputStream(uploadFile);
			addFilePart(inputStream, dos, "file", uploadFile);
			dos.writeBytes(TWO_HYPHENS + BOUNDARY + TWO_HYPHENS + LINE_END);

			// close streams
			inputStream.close();
			dos.flush(); // finish upload...   
			dos.close();
			
			// Starts the query
	        conn.connect();
	        int responseCode = conn.getResponseCode();
	        Log.d("koo", "getResponseCode:"+responseCode);
	         is = conn.getInputStream();
		   
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return is;  
	}

    
    //========================== multipart from 과 관현된 부분 ============================= 추후 패턴 적용 
    //http://codejava.net/java-se/networking/upload-files-by-sending-multipart-request-programmatically
    
    /**
     * Adds a form field to the request
     * @param name field name
     * @param value field value
     * @throws IOException 
     */
    public void addFormField(DataOutputStream dos, String name, String value) throws IOException {
    	dos.writeBytes(TWO_HYPHENS+BOUNDARY+LINE_END);
    	dos.writeBytes("Content-Disposition: form-data; name=\"" + name + "\""+LINE_END);      
    	//dos.writeBytes("Content-Type: text/plain; charset=" + charset+LINE_END);
    	dos.writeBytes(LINE_END);
    	dos.writeBytes(value);
    	dos.writeBytes(LINE_END);
    }
 
    
    /**
     * Adds a upload file section to the request
     * @param fieldName name attribute in <input type="file" name="..." />
     * @param uploadFile a File to be uploaded
     * @throws IOException
     */
    public void addFilePart(InputStream inputStream, DataOutputStream dos, String fieldName, File uploadFile)throws IOException {
    	dos.writeBytes(TWO_HYPHENS + BOUNDARY + LINE_END);
		dos.writeBytes("Content-Disposition: form-data; name=\""+fieldName+"\";fileName=\"" +fileName+"\"" + LINE_END);
		//dos.writeBytes("Content-Transfer-Encoding: binary"+LINE_END);
		dos.writeBytes(LINE_END);
		
		int bytesAvailable = inputStream.available();
		int maxBufferSize = 2048;
		int bufferSize = Math.min(bytesAvailable, maxBufferSize);

		byte[] buffer = new byte[bufferSize];
		int bytesRead = inputStream.read(buffer, 0, bufferSize);

		// read image
		while (bytesRead > 0) {
			dos.write(buffer, 0, bufferSize);
			bytesAvailable = inputStream.available();
			bufferSize = Math.min(bytesAvailable, maxBufferSize);
			bytesRead = inputStream.read(buffer, 0, bufferSize);
		} 
		dos.writeBytes(LINE_END);   
    }
  

    
    
    
    //=======================================================================================
    
    /** Reads an InputStream and converts it to a String.
     * @param stream InputStream containing HTML from targeted site.
     * @param len Length of string that this method returns.
     * @return String concatenated according to len parameter.
     * @throws java.io.IOException
     * @throws java.io.UnsupportedEncodingException
     */
    private String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        String result = new String();
        String buf = null;
    	Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        BufferedReader br = new BufferedReader(reader, len);
        while( ( buf = br.readLine() ) != null ) {
        	result+=buf;
        }
        return result;
    }
    
	private String encodeString(Properties prop) throws UnsupportedEncodingException {
		  StringBuffer sb = new StringBuffer(512);
	      Enumeration names = prop.propertyNames();
	      
	      while (names.hasMoreElements()) {
	         String name = (String) names.nextElement();
	         String value = prop.getProperty(name);
	         sb.append(URLEncoder.encode(name,"UTF-8") + "=" + URLEncoder.encode(value,"UTF-8") );
	         if (names.hasMoreElements()) sb.append("&");
	      }
	      
	      return sb.toString();
	   }
    
	
	
}
