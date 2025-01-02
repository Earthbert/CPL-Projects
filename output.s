    .data
    .align  2
    .globl  class_nameTab
    .globl  Int_protObj
    .globl  String_protObj
    .globl  bool_const0
    .globl  bool_const1
    .globl  Main_protObj
    .globl  _int_tag
    .globl  _string_tag
    .globl  _bool_tag
_int_tag:
    .word   1
_string_tag:
    .word   2
_bool_tag:
    .word   3
class_nameTab:
    .word   string_const1
    .word   string_const2
    .word   string_const3
    .word   string_const4
    .word   string_const5
    .word   string_const6
    .word   string_const7
    .word   string_const8
    .word   string_const9
    .word   string_const10
    .word   string_const11
    .word   string_const12
class_objTab:
    .word   Object_protObj
    .word   Object_init
    .word   Int_protObj
    .word   Int_init
    .word   String_protObj
    .word   String_init
    .word   Bool_protObj
    .word   Bool_init
    .word   IO_protObj
    .word   IO_init
    .word   A_protObj
    .word   A_init
    .word   B_protObj
    .word   B_init
    .word   C_protObj
    .word   C_init
    .word   D_protObj
    .word   D_init
    .word   E_protObj
    .word   E_init
    .word   F_protObj
    .word   F_init
    .word   Main_protObj
    .word   Main_init
string_const0:
    .word   2
    .word   5
    .word   String_dispTab
    .word   int_const0
    .asciiz ""
    .align  2
string_const1:
    .word   2
    .word   6
    .word   String_dispTab
    .word   int_const1
    .asciiz "Object"
    .align  2
string_const2:
    .word   2
    .word   5
    .word   String_dispTab
    .word   int_const2
    .asciiz "Int"
    .align  2
string_const3:
    .word   2
    .word   6
    .word   String_dispTab
    .word   int_const1
    .asciiz "String"
    .align  2
string_const4:
    .word   2
    .word   6
    .word   String_dispTab
    .word   int_const3
    .asciiz "Bool"
    .align  2
string_const5:
    .word   2
    .word   5
    .word   String_dispTab
    .word   int_const4
    .asciiz "IO"
    .align  2
string_const6:
    .word   2
    .word   5
    .word   String_dispTab
    .word   int_const5
    .asciiz "A"
    .align  2
string_const7:
    .word   2
    .word   5
    .word   String_dispTab
    .word   int_const5
    .asciiz "B"
    .align  2
string_const8:
    .word   2
    .word   5
    .word   String_dispTab
    .word   int_const5
    .asciiz "C"
    .align  2
string_const9:
    .word   2
    .word   5
    .word   String_dispTab
    .word   int_const5
    .asciiz "D"
    .align  2
string_const10:
    .word   2
    .word   5
    .word   String_dispTab
    .word   int_const5
    .asciiz "E"
    .align  2
string_const11:
    .word   2
    .word   5
    .word   String_dispTab
    .word   int_const5
    .asciiz "F"
    .align  2
string_const12:
    .word   2
    .word   6
    .word   String_dispTab
    .word   int_const3
    .asciiz "Main"
    .align  2
int_const0:
    .word   1
    .word   4
    .word   Int_dispTab
    .word   0
int_const1:
    .word   1
    .word   4
    .word   Int_dispTab
    .word   6
int_const2:
    .word   1
    .word   4
    .word   Int_dispTab
    .word   3
int_const3:
    .word   1
    .word   4
    .word   Int_dispTab
    .word   4
int_const4:
    .word   1
    .word   4
    .word   Int_dispTab
    .word   2
int_const5:
    .word   1
    .word   4
    .word   Int_dispTab
    .word   1
bool_const0:
    .word   3
    .word   4
    .word   Bool_dispTab
    .word   0
bool_const1:
    .word   3
    .word   4
    .word   Bool_dispTab
    .word   1
Object_protObj:
    .word   0
    .word   3
    .word   Object_dispTab
Int_protObj:
    .word   1
    .word   4
    .word   Int_dispTab
    .word   0
String_protObj:
    .word   2
    .word   5
    .word   String_dispTab
    .word   int_const0
    .asciiz ""
    .align  2
Bool_protObj:
    .word   3
    .word   4
    .word   Bool_dispTab
    .word   0
IO_protObj:
    .word   4
    .word   3
    .word   IO_dispTab
A_protObj:
    .word   5
    .word   3
    .word   A_dispTab
B_protObj:
    .word   6
    .word   3
    .word   B_dispTab
C_protObj:
    .word   7
    .word   3
    .word   C_dispTab
D_protObj:
    .word   8
    .word   3
    .word   D_dispTab
E_protObj:
    .word   9
    .word   3
    .word   E_dispTab
F_protObj:
    .word   10
    .word   3
    .word   F_dispTab
Main_protObj:
    .word   11
    .word   3
    .word   Main_dispTab
Object_dispTable:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
Int_dispTable:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
String_dispTable:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
    .word   String.length
    .word   String.concat
    .word   String.substr
Bool_dispTable:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
IO_dispTable:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
    .word   IO.out_string
    .word   IO.out_int
    .word   IO.in_string
    .word   IO.in_int
A_dispTable:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
B_dispTable:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
C_dispTable:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
D_dispTable:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
E_dispTable:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
F_dispTable:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
Main_dispTable:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
    .word   Main.main
heap_start:
    .word   0
    .text
    .globl  Int_init
    .globl  String_init
    .globl  Bool_init
    .globl  Main_init
    .globl  Main.main
Object_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
Int_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     Object_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
String_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     Object_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
Bool_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     Object_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
IO_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     Object_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
A_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     Object_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
B_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     A_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
C_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     A_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
D_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     B_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
E_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     B_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
F_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     C_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
Main_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     E_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
Main.main:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    la      $a0 int_const0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra