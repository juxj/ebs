package org.tju.ebs.interceptor;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.springframework.aop.MethodBeforeAdvice;


public class AuthenticationAdvice  implements MethodBeforeAdvice  {
	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("try to authentication.");
	}
	
	public Object authPermission(JoinPoint jp) throws Throwable {
		System.out.println("dasldflajskfk");
		return null;
	}
}
