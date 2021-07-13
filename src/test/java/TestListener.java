import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExcelManager;

import java.io.IOException;
import java.util.*;

import static base.BaseClass.getDate;
import static base.BaseClass.getTime;

public class TestListener implements ITestListener {
    private ExcelManager excel = new ExcelManager();
    private HashSet<String> examples = new HashSet<>();
    private HashSet<String> duplicatesExamples = new HashSet<>();

    @Override
    public void onFinish(ITestContext context) {
        Set<ITestResult> irm =  context.getFailedTests().getAllResults();
        Iterator<ITestResult> it = irm.iterator();
        HashSet<String> failedExamples = new HashSet<>();
        while(it.hasNext())
            failedExamples.add(it.next().getParameters()[0].toString());
        if(failedExamples.retainAll(duplicatesExamples)) {
            for (String failedExample : failedExamples) {
                System.out.println("DUP ===== "+failedExample);
                String[] strs = failedExample.split(" ");
                try {
                    excel.excelWriting(strs[strs.length - 1].replace("\"", ""), "KO", getDate(), getTime());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started======== ");
        //String[] strs = result.getParameters()[0].toString().split(" ");
        System.out.println(result.getParameters()[0].toString());
        if(!examples.add(result.getParameters()[0].toString()))
            duplicatesExamples.add(result.getParameters()[0].toString());
        System.out.println(result.getParameters()[0]);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test succeed==========");
        String[] strs = result.getParameters()[0].toString().split(" ");
        try {
            excel.excelWriting(strs[strs.length-1].replace("\"",""), "OK", getDate(), getTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed============");
        String[] strs = result.getParameters()[0].toString().split(" ");
        try {
            excel.excelWriting(strs[strs.length-1].replace("\"",""), "KO", getDate(), getTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
