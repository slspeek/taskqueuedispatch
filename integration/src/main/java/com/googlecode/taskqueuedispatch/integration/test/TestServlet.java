package com.googlecode.taskqueuedispatch.integration.test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import com.googlecode.taskqueuedispatch.TaskQueueDispatch;

@SuppressWarnings("serial")
@Singleton
public class TestServlet extends HttpServlet {
	
	@Inject
	TaskQueueDispatch dispatch;
	
	@SuppressWarnings("rawtypes")
	@Inject
	List results;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		if (name != null) {
			dispatch.execute(new TestAction(name), new TestCallback());
		}
		String second = request.getParameter("second");
		if (second != null) {
			dispatch.execute(new SecondAction(second), new TestCallback());
		}
		OutputStream out = response.getOutputStream();
		PrintWriter p = new PrintWriter(out);
		p.write(outputHTML());
		p.close();
		out.close();
	}

	private String outputHTML() {
		String result = "<html><h1>TaskQueueDispatch Test Servlet</h1><div>";
		for (Object t : results) {
			result += "<div>" + String.valueOf(t) + "</div>";
		}
		result += "</div></html>";
		return result;
	}

}
