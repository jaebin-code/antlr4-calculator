# 계산기 구현 프로젝트
### 이 프로젝트는 ANTLR4와 Java를 사용하여 간단한 계산기를 구현한 것입니다.

## 프로젝트 개요
이 프로젝트는 사용자가 입력한 수식을 파싱하고, AST(Abstract Syntax Tree)를 구축한 다음, 해당 AST를 사용하여 수식을 평가합니다. 다양한 연산을 지원하며, 프로그램은 ANTLR4를 사용하여 수식을 파싱하고 AST를 생성하는데 사용됩니다.

## 사용된 도구 및 라이브러리
ANTLR4: 언어 인식 도구로 사용되었습니다.

Java: 주 언어로 사용되었습니다.

프로젝트 구조

AstCall.java: AST를 호출하여 수식을 계산하는 클래스입니다.

AstNodes.java: AST의 노드들을 정의한 클래스 파일입니다.

BuildAstVisitor.java: ANTLR4 Visitor 인터페이스를 구현하여 AST를 구축하는 Visitor 클래스입니다.

Evaluate.java: AST를 이용하여 수식을 계산하는 클래스입니다.

Expr.g4: ANTLR4 문법 정의 파일입니다.

program.java: 메인 애플리케이션 클래스입니다. 프로그램의 진입점을 제공합니다.

returnProg.java: 프로그램 실행 후 반환할 결과를 정의한 클래스입니다.

## 컴파일 및 실행 방법

# ANTLR4 다운로드
wget https://www.antlr.org/download/antlr-4.9.2-complete.jar

Java 컴파일
javac *.java

메인 애플리케이션 실행
java program
