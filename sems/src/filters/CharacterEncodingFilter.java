package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * 클라이언트가 보낸 데이터가 어떤 문자집합으로 되어있는지 설정하는 필터
 *  - chain of responsibility 패턴의 적용
 *  - 특징 : 임의로 기능을 추가하거나 삭제할 수 있다.
 */

public class CharacterEncodingFilter implements Filter {
  FilterConfig config;
  final String defaultCharSet = "UTF-8";
  /*
   * Wep App. 종료 시 호출됨
   */
  @Override
  public void destroy() {}

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain next) throws IOException, ServletException {
    
    // 1) service() 호출 전 작업
    String charset = config.getInitParameter("charset"); 
    if(charset !=null){
      request.setCharacterEncoding(charset);
    }else{
      request.setCharacterEncoding(defaultCharSet);
    }
    
    // 최종적으로 서블릿의 service()가 호출된다.
    next.doFilter(request, response);
    
    // 2) 서블릿의 service() 호출 후 수행할 작업을 기술
  }

  /*
   * Filter 생성 시 호출됨
   */
  @Override
  public void init(FilterConfig config) throws ServletException {
    this.config = config;
  }

}
