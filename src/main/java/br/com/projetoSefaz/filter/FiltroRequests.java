package br.com.projetoSefaz.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(dispatcherTypes= {DispatcherType.REQUEST}, urlPatterns="/*" )
public class FiltroRequests implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//pq o generico n tem os metodos q precisamos(por ex: ulr, sessao q precisamos)
		//para conseguir acessar sessão
		HttpServletRequest httpReq= (HttpServletRequest) request;
		HttpServletResponse httpResp= (HttpServletResponse) response;
		
		String uri = httpReq.getRequestURI();
		
		HttpSession session = httpReq.getSession(false);
		
		//se for a página de login ou do autenticador, então o filtro "permite a passagem".
		if(session != null || uri.lastIndexOf("index.jsp")!=-1 || uri.lastIndexOf("autenticador.do")!=-1) {
			chain.doFilter(request, response);
		}
		else {
			httpResp.sendRedirect("index.jsp");
		}
		
		System.out.println("passou pelo filtro!");
		
	}
	
	

}
