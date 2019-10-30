
import org.eclipse.jface.action.*
import org.eclipse.jface.resource.ImageDescriptor
import org.eclipse.jface.window.ApplicationWindow
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.Point
import org.eclipse.nebula.widgets.pshelf.*
import org.eclipse.swt.custom.SashForm
import org.eclipse.swt.layout.FillLayout
import java.io.IOException
import java.io.File
import org.eclipse.jface.resource.ImageDescriptor.createFromFile
import org.eclipse.swt.widgets.*


class MainWindow (parentShell: Shell?): ApplicationWindow(parentShell) {



    init {
        addMenuBar()
        addToolBar(SWT.WRAP)
        addStatusLine()

    }




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
        val lblAddress: DocumentView = DocumentView(mainContainer)
        return container
    }

    override fun createMenuManager(): MenuManager {

       val actionOpenFile: Action = object : Action("Open") {
            override fun run() {
                val dialog = FileDialog(shell, SWT.OPEN)
                val file = dialog.open()
                if (file != null) {
                    try {
                        setStatus("File loaded successfully")
                    } catch (e: IOException) {
                        e.printStackTrace()
                        setStatus("Failed to load file")
                    }

                }
            }
        }

        val menuManager = MenuManager("")
        val fileMenu = MenuManager("&File")
        fileMenu.add(Separator())
        fileMenu.add(actionOpenFile)
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