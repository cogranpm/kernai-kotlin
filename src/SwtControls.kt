import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.widgets.Label

fun getLabel(caption: String, parent: Composite ) : Label {
    val label: Label = Label(parent, SWT.NONE)
    label.text = caption
    return label
}


