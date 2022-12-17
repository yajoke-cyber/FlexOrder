package com.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	protected String encoding = null;

	protected FilterConfig filterConfig = null;

	public void destroy() {
		this.encoding = null;
		this.filterConfig = null;
	}
//����encodingfilterͳһ�����ַ���

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {		
		String encoding = selectEncoding(request);
		if (encoding != null) { // ��������б�������
			request.setCharacterEncoding(encoding);
			response.setCharacterEncoding(encoding);
		}
		// ������Ȩ���ݸ���һ��������
		chain.doFilter(request, response);
	}
//��doFilter�����з��������ΪoFilter�����ĵ�һ������ΪServletRequest���󣬴˶�����������ṩ�˶Խ������Ϣ�����������ݣ�cookie��HTTP����ͷ������ȫ���ʣ�
//�ڶ�������ΪServletResponse����ͨ���ڼ򵥵Ĺ������к��Դ˲��������һ������ΪFilterChain������һ���������˲�������Servlet��JSPҳ��
//����FilterChain�����doFilter������Filter�ӿڵ�doFilter����ȡһ��FilterChain������Ϊ����һ���������ڵ��ô˶����doFilter����ʱ��
//������һ����ع����������û����һ����������Servlet��JSPҳ�汻����
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");
	}
// ��ʼ������  
	protected String selectEncoding(ServletRequest request) {
		return (this.encoding);
	}
}
