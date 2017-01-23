package com.tedu.cloudnote.aspect;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
//扫描到spring容器
@Component
//指定为切面组件，往其他切点当中进行切入
@Aspect
public class ExceptionBean {

	//当目标方法抛出异常之后调用
	
	@AfterThrowing(throwing="e",pointcut="within(com.tedu.cloudnote.controller..*)")
	//e是目标组件抛出的异常对象
	public void execute(Exception e){
		//将异常信息写入文件中
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("D:\\note_error.log",true));
			//利用pw对象写信息
			Date time = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
			String t = sdf.format(time);
			pw.println("**********************************");
			pw.println("*异常类型："+e);
			pw.println("*发生时间："+t);
			pw.println("**********异常详情****************");
			e.printStackTrace(pw);
			pw.close();
		} catch (IOException e1) {
			System.out.println("记录异常失败");
		}
		
	}
}
