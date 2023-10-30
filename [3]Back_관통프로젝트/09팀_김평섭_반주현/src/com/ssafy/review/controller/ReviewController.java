package com.ssafy.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.review.model.dto.Review;
import com.ssafy.review.model.service.ReviewService;
import com.ssafy.review.model.service.ReviewServiceImpl;

@WebServlet("/review")
public class ReviewController extends HttpServlet {


	private ReviewService service = ReviewServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		if (request.getMethod().equals("POST"))
			request.setCharacterEncoding("UTF-8");

		String act = request.getParameter("act");

		switch (act) {
		case "list":
			doList(request, response);
			break;
		case "writeform":
			doWriteForm(request, response);
			break;
		case "write":
			doWrite(request, response);
			break;
		case "detail":
			doDetail(request, response);
			break;
		case "updateform":
			doUpdateForm(request, response);
			break;
		case "update":
			doUpdate(request, response);
			break;
		case "delete":
			doRemove(request, response);
			break;
		default:
			break;
		}

	}

	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		service.removeReview(id);
		response.sendRedirect("review?act=list");
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Review review = new Review();
		review.setId(id);
		review.setTitle(title);
		review.setContent(content);
		review.setWriter(writer);
		
		service.modifyReview(review);
		response.sendRedirect("review?act=list");
		
	}

	private void doUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Review review = service.getReview(id);
		request.setAttribute("review", review);
		request.getRequestDispatcher("/review/updateform.jsp").forward(request, response);
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("review", service.getReview(id));
		request.getRequestDispatcher("/review/detail.jsp").forward(request, response);
	}

	private void doWrite(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		Review review = new Review(title, writer, content);

		service.writeReview(review);

		response.sendRedirect("review?act=list");

	}

	private void doWriteForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/review/writeform.jsp").forward(request, response);
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서비스호출 -> Dao 호출 -> 돌려줘 돌려줘 -> list.jsp 포워딩 하겠다.
		request.setAttribute("list", service.getList());
		request.getRequestDispatcher("/review/list.jsp").forward(request, response);

	}
}
