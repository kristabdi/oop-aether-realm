import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

public class Util {
    // buat print semua component anak
    public static List<Component> getAllComponents(final Container c) {
        Component[] comps = c.getComponents();
        List<Component> compList = new ArrayList<Component>();
        for (Component comp : comps) {
            System.out.println("comp");
            System.out.println(comp);
            compList.add(comp);
            if (comp instanceof Container) {
            compList.addAll(getAllComponents((Container) comp));
            }
        }
        return compList;
    }
}
