package org.kamiblue.client.util.graphics.compat

import org.lwjgl.opengl.ARBVertexBufferObject
import org.lwjgl.opengl.GL15
import java.nio.ByteBuffer

fun glGenBuffersC(): Int {
    return if (GlCompatFlags.arbVbo) ARBVertexBufferObject.glGenBuffersARB()
    else GL15.glGenBuffers()
}

fun glBindBufferC(target: Int, buffer: Int) {
    if (GlCompatFlags.arbVbo) {
        ARBVertexBufferObject.glBindBufferARB(target, buffer)
    } else {
        GL15.glBindBuffer(target, buffer)
    }
}

fun glBufferDataC(target: Int, data: ByteBuffer, usage: Int) {
    if (GlCompatFlags.arbVbo) {
        ARBVertexBufferObject.glBufferDataARB(target, data, usage)
    } else {
        GL15.glBufferData(target, data, usage)
    }
}

fun glBufferSubDataC(target: Int, offset: Long, data: ByteBuffer) {
    if (GlCompatFlags.arbVbo) {
        ARBVertexBufferObject.glBufferSubDataARB(target, offset, data)
    } else {
        GL15.glBufferSubData(target, offset, data)
    }
}