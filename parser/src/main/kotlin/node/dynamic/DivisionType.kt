package node.dynamic

import operations.DynamicVisitor

class DivisionType(val left: DynamicNode, val right: DynamicNode, override var result: LiteralValue?) : DynamicNode {

    override fun visit(visitor: DynamicVisitor) {
        visitor.acceptDivision(this)
    }
}
