package hello.hello_spring_self_practice_ver1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TimeTraceAop {

//    @Around("execution(* hello.hello_spring_self_practice_ver1..*(..))")
//    순환 참조 문제 발생
    @Around("execution(* hello.hello_spring_self_practice_ver1..*(..)) && !target(hello.hello_spring_self_practice_ver1.SpringConfig)")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());

        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }

}
