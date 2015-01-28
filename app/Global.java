import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.vini.demo.taskmanager.applifecycle.AppLifecycle;
import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings {

    private Injector injector;

    @Override
    public void onStart(Application application) {
        AppLifecycle appLifecycle = new AppLifecycle();
        appLifecycle.onStart();
    }

    @Override
    public <T> T getControllerInstance(Class<T> aClass) throws Exception {
        return AppLifecycle.injector().getInstance(aClass);
    }
}
