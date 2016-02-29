package dha.pkg.java;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UploadDownloadFileServlet")
public class ImgDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //private ServletFileUpload uploader = null;
	@Override
	public void init() throws ServletException{
		//DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		//File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		//fileFactory.setRepository(filesDir);
		//this.uploader = new ServletFileUpload(fileFactory);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath = "C:/images/images.jpg";
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);
         
        // if you want to use a relative path to context root:
        String relativePath = getServletContext().getRealPath("");
        System.out.println("relativePath = " + relativePath);
         
        // obtains ServletContext
        ServletContext context = getServletContext();
         
        // gets MIME type of the file
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {        
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
         
        // modifies response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
         
        // forces download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);
         
        // obtains response's output stream
        OutputStream outStream = response.getOutputStream();
         
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
         
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
         
        inStream.close();
        outStream.close();     
    }

/*import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInputStream; 
import java.io.File; 
import java.io.FileInputStream;
import javax.servlet.ServletContext; 
import javax.servlet.ServletOutputStream;

*//**
 * Servlet implementation class ImgDownloadServlet
 *//*
public class ImgDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int BUFSIZE = 4096;
    private String filePath;
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public ImgDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	*//**
	 * @see Servlet#init(ServletConfig)
	 *//*
	public void init() {
		// TODO Auto-generated method stub
		filePath = getServletContext().getRealPath("/images/2.jpg")  + File.separator;// + "data.xls";
	}

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 File file = new File(filePath);
		 System.out.print("" +file);
		    int length   = 0;
		    ServletOutputStream outStream = response.getOutputStream();
		    ServletContext context  = getServletConfig().getServletContext();
		    String mimetype = context.getMimeType(filePath);

		    // sets response content type
		    if (mimetype == null) {
		        mimetype = "application/octet-stream";
		    }
		    response.setContentType(mimetype);
		    response.setContentLength((int)file.length());
		    String fileName = (new File(filePath)).getName();

		    // sets HTTP header
		    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

		    byte[] byteBuffer = new byte[BUFSIZE];
		    DataInputStream in = new DataInputStream(new FileInputStream(file));

		    // reads the file's bytes and writes them to the response stream
		    while ((in != null) && ((length = in.read(byteBuffer)) != -1))
		    {
		        outStream.write(byteBuffer,0,length);
		    }

		    in.close();
		    outStream.close();
		
	}*/

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
