package ru.popovbodya

enum class RevolutFunction(val id: String, val desc: String, val impl: (String) -> String) {
    A("a", "замена r/R на a", { base: String -> base.replace(Regex("[rR]"), "a") }),
    B("b", "удаление последнего символа", { base: String -> base.dropLast(1) }),
    C("c", "конвертация в EritiEalbug", { "EritiEalbug" }),
    D("d", "удаление первого символа", { base: String -> base.drop(1) }),
    E("e", "нижний регистр для символов с чётным индексом", String::lowerCaseForEven),
    F("f", "добавление F в начале строки", { base: String -> "F$base" }),
    G("g", "добавление T в конце строки", { base: String -> "{$base}T" }),
    H("h", "конвертация в пустую строку", { "" }),
    I("i", "удаление символа i в строке", { base: String -> base.replace(Regex("[iI]"), "") }),
    J("j", "пасхалка про дроидов", { base: String -> "$base These Are Not the Droids You Are Looking For" }),
    K("k", "добавление e в начале, E в конце", { base: String -> "e{$base}E" }),
    L("l", "перемещение первого символ в строке из начала в конец", String::moveFirstSymbolToEnd),
    M("m", "замена bug на fix", { base: String -> base.replace("bug", "fix") }),
    N("n", "reverse строки", { base: String -> base.reversed() }),
    O("o", "нижний регистр для символов с нечетным индексом", String::lowerCaseForOdd),
    P("p", "пасхалка Princess is in Another Castle", { base: String -> "$base Princess is in Another Castle" }),
    Q("q", "вся строка в верхний регистр", String::toUpperCase),
    R("r", "reverse регистра", String::reverseCase),
    S("s", "добавление E в начало, uR в конец", { base: String -> "E${base}uR" }),
    T("t", "конвертация к верхнему регистру каждый 3 символ", String::upperCaseByThree),
    U("u", "удаление подстроки bug", { base: String -> base.replace("bug", "") }),
    V("v", "замена e на 3, i на 1", { base: String -> base.replace(Regex("[eE]]"), "3").replace(Regex("[iI]"), "1") }),
    W("w", "добавление T в начало", { base: String -> "T$base" }),
    X("x", "добавление префикса feat. Eminem", { base: String -> "feat. Eminem$base" }),
    Y("y", "добавление суффикса TORTURE", { base: String -> "${base}TORTURE" }),
    Z("z", "удаляет символы l и L из строки", { base: String -> base.replace(Regex("[lL]"), "") })
}

private fun String.moveFirstSymbolToEnd() = if (isNotEmpty()) "${drop(1)}${get(0)}" else ""

private fun String.lowerCaseForEven() = lowerCaseForEvenOrOdd(true)

private fun String.lowerCaseForOdd() = lowerCaseForEvenOrOdd(false)

private fun String.lowerCaseForEvenOrOdd(isEven: Boolean): String {
    val rem = if (isEven) 0 else 1
    val result = CharArray(this.length) { index: Int ->
        if (index.rem(2) == rem) {
            this[index].toLowerCase()
        } else {
            this[index]
        }
    }
    return String(result)
}

private fun String.upperCaseByThree(): String {
    var counter = 0
    val result = CharArray(this.length) { index: Int ->
        if (counter == 0) {
            counter = 2
            this[index].toUpperCase()
        } else {
            counter--
            this[index]
        }
    }
    return String(result)
}

private fun String.reverseCase(): String {
    val result = CharArray(this.length) { index: Int ->
        val ch = this[index]
        if (ch.isUpperCase()) ch.toLowerCase() else ch.toUpperCase()
    }
    return String(result)
}

