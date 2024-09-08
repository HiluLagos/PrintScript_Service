package node.dynamic

import node.PrimType
import node.TypeValue
import operations.DynamicVisitorV1

class SumType(val left: DynamicNode, val right: DynamicNode, override var result: LiteralValue?) : DynamicNode {
    override fun visit(visitor: DynamicVisitorV1) {
        visitor.acceptSum(this)
    }

    override fun execute(valueMap: Map<String, Pair<Boolean, TypeValue>>, version: String): TypeValue {
        val left = left.execute(valueMap, version)
        val right = right.execute(valueMap, version)
        val type = if (left.type == PrimType.STRING || right.type == PrimType.STRING) PrimType.STRING else left.type
        return TypeValue(left.value!! + right.value!!, type)
    }

    override fun format(version: String): String {
        return "${left.format(version)} + ${right.format(version)}"
    }

    override fun toString(): String {
        return "SumType(left='$left', right=$right)"
    }
}
