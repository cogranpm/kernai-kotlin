
import org.eclipse.jface.action.MenuManager
import org.eclipse.jface.action.Separator
import org.eclipse.jface.action.StatusLineManager
import org.eclipse.jface.action.ToolBarManager
import org.eclipse.jface.window.ApplicationWindow
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.Point
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Shell
import org.eclipse.nebula.widgets.pshelf.*
import org.eclipse.swt.custom.SashForm
import org.eclipse.swt.layout.FillLayout


class MainWindow : ApplicationWindow(null) {

    override fun createContents(parent: Composite?): Control {
        val container = Composite(parent, SWT.NONE)
        container.layout = FillLayout()
        val sashForm: SashForm = SashForm(container, SWT.HORIZONTAL)
        val weights: Array<Int> = arrayOf(1, 2)
        val navContainer: Composite = Composite(sashForm, SWT.NONE)
        val mainContainer = Composite(sashForm, SWT.NONE)
        sashForm.weights = weights.toIntArray()
        navContainer.layout= FillLayout(SWT.VERTICAL)
        mainContainer.layout = FillLayout(SWT.VERTICAL)

        val lblName: Label = getLabel("fred", navContainer)
        val lblAddress: Label = getLabel("9999999999", mainContainer)
        return container
    }

    override fun createMenuManager(): MenuManager {
        val menuManager = MenuManager("Menu")
        val fileMenu = MenuManager("&File")
        fileMenu.add(Separator())
        menuManager.add(fileMenu)
        return menuManager
    }

    override fun createToolBarManager(style: Int): ToolBarManager {
        val toolBarManager = ToolBarManager(SWT.NONE);
        toolBarManager.update(true)
        return toolBarManager
    }



    override fun createStatusLineManager(): StatusLineManager {
        return StatusLineManager()
    }

    override fun configureShell(shell: Shell?) {
        super.configureShell(shell)
        shell?.text = "Kernai Kotlin"
    }

    override fun getInitialSize(): Point {
        return Point(900, 900)
    }
}