package de.iteratec.kotlin.playground

fun header(name: String) = """
Dear ${name},
    
"""

val footer = """
            
Yours sincerely, Harald Answer-Machine
Certified bullshitting expert"""

fun writeLetterNoReceiver(name: String, messageCustomizer: (StringBuilder) -> Unit): String {
    val letterBuilder = StringBuilder()
    letterBuilder.append(header(name))
    messageCustomizer(letterBuilder)
    letterBuilder.append(footer)

    return letterBuilder.toString()
}

// We have already seen that we can define so-called extension functions outside a class that can only be called on a receiver and can access it by "this".
// We remind you that extension functions are only syntactic sugar and are replaced with ordinary functions by the compiler. They allow us to make utility functions more beautiful for instance.

// As an extension of this concept, we can also define lambdas with receivers.
fun writeLetterReceiver(name: String, messageCustomizer: StringBuilder.() -> Unit): String {
    val letterBuilder = StringBuilder()
    letterBuilder.append(header(name))
    letterBuilder.messageCustomizer()
    letterBuilder.append(footer)

    return letterBuilder.toString()
}

// Lambdas with receivers can help us to write Domain-specific languages (DSLs)

interface Node {
    fun print(): String
}

open class NodeWithChildren(val tagname: String) : Node {
    val children: MutableList<Node> = mutableListOf()

    override fun print(): String =
        "<${tagname}>\n" +
                children.fold("") { accumulator: String, nextElement: Node -> accumulator + nextElement.print() } +
                "</${tagname}>\n"

    fun addChild(node: Node) = children.add(node)
}

open class TextNode(val text: String) : Node {
    override fun print() = "$text\n"
}

class HtmlNode : NodeWithChildren("html")
class UlNode : NodeWithChildren("ul")
class LiNode : NodeWithChildren("li")

fun html(childrenNodes: (HtmlNode).() -> Unit): String {
    val root = HtmlNode()
    root.childrenNodes()
    return root.print()
}

fun NodeWithChildren.ul(childrenNodes: (UlNode).() -> Unit) {
    val ulNode = UlNode()
    this.addChild(ulNode)
    ulNode.childrenNodes()
}

fun UlNode.li(childrenNodes: (LiNode).() -> Unit) {
    val liNode = LiNode()
    this.addChild(liNode)
    liNode.childrenNodes()
}

fun NodeWithChildren.text(content: String) {
    val text = TextNode(content)
    this.addChild(text)
}


// Lambdas with receivers are almost exclusively used as argument of other function (typically last argument).
// Since the lambda with receiver needs a proper receiver, it is the responsability of the other function to provide some and call the lambda on it.
fun main() {
    val letterNoReceiver = writeLetterNoReceiver("0815-Kunde") {
        it.append("It depends.")
    }

    val letterReceiver = writeLetterReceiver("0815-Kunde") {
        append("It depends.")
    }

    println(letterNoReceiver)
    println("----------------------------")
    println(letterReceiver)

    println(
        html {
            ul {
                li {
                    text("Item 1")
                }
                li {
                    text("Item 2")
                }
                ul {
                    li {
                        text("Nested item")
                    }
                }
            }
        }
    )

}

