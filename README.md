# Straightline

Straightline é uma micro linguagem de programação usada na série de
livros _Modern Compiler Implementation_ escritos por Andrew Appel.

# Gramática

Stm → Stm ; Stm (CompoundStm)
Stm → id := Exp (AssignStm)
Stm → print ( ExpList ) (PrintStm)

Exp → id (IdExp)
Exp → num (NumExp)
Exp → Exp Binop Exp (OpExp)
Exp → ( Stm , Exp ) (EseqExp)

ExpList → Exp (LastExpList)
ExpList → Exp , ExpList (PairExpList)

Binop → + (Plus)
Binop → − (Minus)
Binop → × (Times)
Binop → / (Div)
