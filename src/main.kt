import org.eclipse.swt.widgets.Display
import org.eclipse.core.databinding.observable.Realm
import org.eclipse.jface.databinding.swt.DisplayRealm

fun main() {


    val display: Display = Display.getDefault()
    Realm.runWithDefault(DisplayRealm.getRealm(display), object: Runnable {
        override fun run() : Unit {
        try {
            val window = MainWindow()
           window.setBlockOnOpen(true)
            window.open()
            Display.getCurrent().dispose()
        } catch (ex: Exception){
           //
        }
    }
    })



}