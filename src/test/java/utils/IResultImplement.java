package utils;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class IResultImplement implements IInvokedMethodListener {

    long startTime=0;

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult result) {
        startTime=result.getStartMillis();
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        boolean ifTest=Arrays.asList(
                        result
                                .getMethod()
                                .getConstructorOrMethod()
                                .getMethod()
                                .getDeclaredAnnotations())
                .toString()
                .startsWith("[@org.testng.annotations.Test");

        if(ifTest) {
            String suiteName=result.getTestContext().getSuite().getName();
            String className=result.getInstanceName();
            String testName=result.getName();
            String status=getResultStatusName(result.getStatus());
            String executionTime=(result.getEndMillis()-startTime)+"ms";
            String dateTimeOfExecution=new SimpleDateFormat("yyyy_MMM_dd_HH:mm:ss").format(new Date());
            try {
                writeToFile(suiteName, className, testName, status, executionTime, dateTimeOfExecution);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getResultStatusName(int status) {
        String resultName = null;
        if (status == 1) resultName = "PASSED";
        if (status == 2) resultName = "FAILED";
        if (status == 3) resultName = "SKIPPED";
        return resultName;
    }

    private void writeToFile(String suiteName, String className, String testName, String status, String executionTime,
                             String dateTimeOfExecution) throws IOException, InterruptedException {
        Path project_Dir= Paths.get(System.getProperty("user.dir"));

        if(project_Dir.toString().contains("target")){
            project_Dir=project_Dir.getParent();
        }

        File file = new File( project_Dir.toString()+ "//test_metrics.csv");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(),true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append("\n"+suiteName+","+className+","+testName+","+status+","+executionTime+","+dateTimeOfExecution);
        bufferedWriter.close();
    }

}
