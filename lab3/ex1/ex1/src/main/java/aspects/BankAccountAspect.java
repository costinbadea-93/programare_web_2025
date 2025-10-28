package aspects;

import model.BankAccount;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class BankAccountAspect {

    @Pointcut("execution(* service.BankAccountService.*(..))")
    private void bankAccountPointCut() {}

//    @Before("bankAccountPointCut()")
//    public void beforeAspect(JoinPoint joinPoint) {
//     String methodName = joinPoint.getSignature().getName();
//     Object [] methodArgs =  joinPoint.getArgs();
//     System.out.println("Before method: " + methodName + " with arguments: " + Arrays.toString(methodArgs));
//    }

//    @After("bankAccountPointCut()")
//    public void afterAspect(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        Object [] methodArgs =  joinPoint.getArgs();
//        System.out.println("After method: " + methodName + " with arguments: " + Arrays.toString(methodArgs));
//    }
//
//    @AfterReturning(value = "bankAccountPointCut()", returning = "result")
//    public void afterReturningAspect(JoinPoint joinPoint, Object result) {
//        String methodName = joinPoint.getSignature().getName();
//        Object [] methodArgs =  joinPoint.getArgs();
//        System.out.println("After method: " + methodName + " with arguments: " + Arrays.toString(methodArgs) + " returned: " + result);
//    }


//    @AfterThrowing(value = "bankAccountPointCut()", throwing = "result")
//    public void afterThrowingAspect(JoinPoint joinPoint, Throwable result) {
//        String methodName = joinPoint.getSignature().getName();
//        Object [] methodArgs =  joinPoint.getArgs();
//        System.out.println("Exception in method: " + methodName + " with arguments: " + Arrays.toString(methodArgs) + " exception: " + result.getMessage());
//    }

    @Around("bankAccountPointCut()")
    public Object aroundAspect(ProceedingJoinPoint proceedingJoinPoint) {
        BankAccount b1 = BankAccount.builder()
                .accountNumber("0000503C5")
                .accountOwner("Mihaita Barbu")
                .balance(2500.0)
                .build();

        BankAccount b2 = BankAccount.builder()
                .accountNumber("0000504C5")
                .accountOwner("Gabriel Ionel")
                .balance(2500.0)
                .build();

        try {
            proceedingJoinPoint.proceed(new Object[]{b1,b2, 2000});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
