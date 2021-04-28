package handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
/**
 * 인증성공(로그인성공)후 처리될 핸들러
 * @author user
 *
 */
public class MyLoginSuccessHandler implements AuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
			HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		String contextPath = request.getContextPath();

		List<String> roleNames = new ArrayList<>();
		auth.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});

		if (roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect(contextPath+"/c4u/admin");
			return;
		}
		if (roleNames.contains("ROLE_MEMBER")) {

			response.sendRedirect(contextPath+"/c4u/member");
			return;
		}
		response.sendRedirect(contextPath+"/");

		//		String userName = auth.getName(); //인증된 username
		//		String contextPath = request.getContextPath();
		//		if(userName.equals("admin")) {
		//			response.sendRedirect(contextPath + "/sample/admin");
		//		}else if(userName.contentEquals("memeber")) {
		//			response.sendRedirect(contextPath + "/sample/member");
		//		}else {
		//			response.sendRedirect(contextPath + "/");
		//		}

	}

}
