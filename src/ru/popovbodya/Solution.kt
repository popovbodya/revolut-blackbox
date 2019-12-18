package ru.popovbodya

import ru.popovbodya.RevolutFunction.*

fun main(args: Array<String>) {

    // revolut solution: blackbox.c().u().z().i().f().a().b().b().s().l().o().e().string
    val result = execute {
        registerFunction(C.impl)
        registerFunction(U.impl)
        registerFunction(Z.impl)
        registerFunction(I.impl)
        registerFunction(F.impl)
        registerFunction(A.impl)
        registerFunction(B.impl)
        registerFunction(B.impl)
        registerFunction(S.impl)
        registerFunction(L.impl)
        registerFunction(O.impl)
        registerFunction(E.impl)
    }
    println(result)

    // findBetterWay()
}

private fun findBetterWay() {
    sol(0, "")
}

private val functionsArray: Array<RevolutFunction> =
    arrayOf(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z)

private fun sol(count: Int, result: String) {
    if (count == 11) {
        return
    }

    for (function in functionsArray) {
        val computed = function.impl(result)
        if (computed == "feature") {
           println("success with count: $count")
        }
        sol(count + 1, computed)
    }
}

private fun solWithTrace(count: Int, result: String, trace: String) {

    if (count == 7) {
        return
    }

    for (function in functionsArray) {
        val computed = function.impl(result).toLowerCase()
        if (computed == "feature") {
            println("$trace${function.id}")
        }
        solWithTrace(count + 1, computed, "$trace${function.id}")
    }
}


class FunctionExecutor {

    private val functionList: MutableList<(String) -> String> = mutableListOf()

    fun registerFunction(function: (String) -> String) {
        functionList.add(function)
    }

    fun executeFunctions(): String {
        return functionList.fold("criticalbug") { acc, function -> function.invoke(acc) }
    }
}

fun execute(initBlock: FunctionExecutor.() -> Unit): String {
    return FunctionExecutor().apply(initBlock).executeFunctions()
}