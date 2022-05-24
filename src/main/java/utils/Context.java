package utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Tracing;

import java.nio.file.Paths;
public class Context {

    private static BrowserContext contextVideo;
    private static BrowserContext contextTracing;

    public static BrowserContext setContextVideo(Browser browser){
        contextVideo = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get("C:\\Projects\\Playwright\\video"))
                .setRecordVideoSize(640, 480));
        return contextVideo;
    }

    public static BrowserContext setTracingContext(Browser browser){
        contextTracing = browser.newContext();
        contextTracing.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));
        return contextTracing;
    }

    public static void closeContextVideo(){
        contextVideo.close();
    }

    public static void stopTracingContext(){
        contextTracing.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
    }
}
