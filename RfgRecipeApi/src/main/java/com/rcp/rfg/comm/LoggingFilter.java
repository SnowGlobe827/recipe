package com.rcp.rfg.comm;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
//이 클래스를 서블릿 필터로 설정. filterName = "loggingFilter"는 필터의 이름을 정의, urlPatterns = "/*"는 모든 URL 패턴에 대해 이 필터가 적용되도록 설정
@WebFilter(filterName = "loggingFilter", urlPatterns = "/*")
public class LoggingFilter implements Filter {@Override
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		HttpServletRequest req = (HttpServletRequest)request;
		String url = StringUtils.defaultIfEmpty(req.getRequestURL().toString(), "-") ;
		String quertString = StringUtils.defaultIfEmpty(req.getQueryString(), "-") ;
		String remoteAddr = StringUtils.defaultIfEmpty(req.getRemoteAddr(), "-");
		
		String userAgent = StringUtils.defaultIfEmpty(req.getHeader("User-Agent"), "-") ;
		String referer = StringUtils.defaultIfEmpty(req.getHeader("Referer"), "-") ;
		
		String logger = String.format("[LoggingFilter] %s?%s : %s \n %s %s \n", url, quertString, remoteAddr, userAgent, referer );
		
		log.info(logger);
		
		chain.doFilter(request, response);
		
	}

}
