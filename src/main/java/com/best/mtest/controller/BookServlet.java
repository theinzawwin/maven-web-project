package com.best.mtest.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.best.mtest.Book;
import com.best.mtest.dao.BookDao;


@WebServlet("/BookServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String uploadDir="upload_images";
	private BookDao bookDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        bookDao=new BookDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action="list";
		if(request.getParameter("action")!=null) {
			action=request.getParameter("action");
		}
		if(action.equals("list")) {
			RequestDispatcher rd=request.getRequestDispatcher("bookList.jsp");
			try {
				request.setAttribute("bookList", bookDao.getBookList());
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(action.equals("new")) {
			RequestDispatcher rd=request.getRequestDispatcher("newBook.jsp");
			try {
				request.setAttribute("categoryList", bookDao.getBookCategory());
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String appPath = request.getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + uploadDir;
         
        String name=request.getParameter("name");
        int qty=Integer.parseInt(request.getParameter("qty"));
        Integer catId=Integer.parseInt(request.getParameter("categoryId"));
        
            try {
            	
            	/*Part part=request.getPart("photo");
                // creates the save directory if it does not exists
                File fileSaveDir = new File(savePath);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdir();
                }
               
             
                    String fileName = extractFileName(part);
                   
                    // refines the fileName in case it is an absolute path
                    fileName = new File(fileName).getName();
                    part.write(savePath + File.separator + fileName);
                     */
                    Book book=new Book(0,name,"",qty,catId);
				bookDao.saveBook(book);
				RequestDispatcher rd=request.getRequestDispatcher("bookList.jsp");
				request.setAttribute("bookList", bookDao.getBookList());
rd.forward(request, response);				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
	}
	
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }

}
