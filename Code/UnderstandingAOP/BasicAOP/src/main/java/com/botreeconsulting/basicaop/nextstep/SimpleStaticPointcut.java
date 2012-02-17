package com.botreeconsulting.basicaop.nextstep;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {
	
	@SuppressWarnings("rawtypes")
	public boolean matches(Method method, Class arg1) {
		return ("bar".equalsIgnoreCase(method.getName()));
	}
	
	@SuppressWarnings("rawtypes")
	public ClassFilter getClassFilter() {
        return new ClassFilter() {            
			public boolean matches(Class cls) {
                return (cls == BeanOne.class);
            }
        };
    
    }
}
