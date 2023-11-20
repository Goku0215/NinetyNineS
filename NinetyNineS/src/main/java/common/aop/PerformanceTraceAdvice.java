package common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class PerformanceTraceAdvice {
	
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		Signature signature = joinPoint.getSignature();
		System.out.println("PerformanceTraceAdvice : " + signature.toShortString() + " Start");
		long start = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			System.out.println("PerformanceTraceAdvice : " +signature.toShortString() + " RunTime : "+(System.currentTimeMillis() - start)+"ms");
		}
	}
	
}