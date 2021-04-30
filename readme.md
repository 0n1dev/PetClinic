# 예제로 배우는 스프링 입문
---

# 빌드란?
---

- 소스코드와 프로젝트에서 쓰인 파일 및 자원 등을 JVM이나 톰캣같은 WAS가 인식할 수 있는 구조로 패키징 하는 것

## 빌드 도구

> 프로젝트 생성, 테스트 빌드, 배포 등의 작업을 위한 전용 프로그램

- Maven과 Gradle을 주로 사용됨

# Maven
---

- 필요한 특정 의존성들을 pom.xml에 정의해 놓으면 내가 사용할 의존성뿐만 아니라 해당 의존성이 동작하는데 필요한 다른 의존성까지 관리하여 
네트워크를 통해 자동으로 다운로드

## Maven LifeCycle
---

> 미리 정해진 빌드순서

- Default(Build) : 일반적인 빌드 프로세스를 위한 모델
- Clean : 빌드 시 생성되었던 파일들을 삭제하는 단계
- Validate : 프로젝트가 올바른지 확인하고 필요한 모든 정보를 사용할 수 있는지 확인하는 단계
- Compile : 프로젝트의 소스코드를 컴파일 하는 단계
- Test : 단위 테스트를 수행하는 단계 (테스트 실패시 빌드 실패로 처리)
- Package : 실제 컴파일된 소스 코드와 리소스들을 jar, war 등의 배포를 위한 패키지로 만드는 단계
- Verify : 통합 테스트 결과에 대한 검사를 실행하여 품질 기준을 충족하는지 확인하는 단계
- Install : 패키지를 로컬 저장소에 설치하는 단계
- Site : 프로젝트 문서와 사이트 작성, 생성하는 단계
- Deploy : 만들어진 package를 원격 저장소에 release 하는 단계

최종 빌드 순서는 compile -> test -> package

- compile : src/main/java 디렉토리 아래의 모든 소스 코드가 컴파일
- test : src/test/java, src/test/resources 테스트 자원 복사 및 테스트 소스 코드 컴파일
- packaging : 컴파일과 테스트가 완료 된 후 jar, war 과 같은 형태로 압축하는 작업

# IOC
---

> Inversion of Control의 약자

- 기존에는 의존 관계 연결 작업에 대한 제어권은 개발되는 어플리케이션에 있음
- Servlet, EJB 등을 사용하는 경우 제어권이 넘어가 객체의 생명주기를 컨테이너들이 전담
- IoC는 객체의 생성부터 생명주기의 관리까지 모든 객체에 대한 제어권이 바뀌었다는것을 의미

## 장/단점
---

### 장점

- 인터페이스 기반 설계가 가능
- 컴포넌트 재사용성 증가
- 체계적이고 효율적인 의존성 관리

### 단점

- 제어구조가 반대로 되어 이해하기 어려운 코드가 될 수 있음

# IoC 컨테이너란?
---

- 객체를 관리 및 의존성을 관리하는 컨테이너
- POJO 생성, 초기화, 서비스 소멸에 관한 모든 권한을 가지면서 POJO의 생명 주기를 관리
- 개발자들이 POJO를 생성할 수 있지만, 모든 권한을 컨테이너에게 맡김

# DI란?
---

> Dependency Injection 의존성 삽입

- 각 클래스 사이의 의존관계를 Bean Definition 정보를 바탕으로 컨테이너가 자동적으로 연결해주는 것
- 개발자들은 단지 빈 설정파일에서 의존관계가 필요하다는 정보를 추가하면 됨

## DI 종류
---

- Constructor Injection
- Setter Injection
- Field Injection

# AOP
---

> 관점 지향 프로그래밍

```java
class A {

    method a() {
        AAAA
        얍얍얍얍
        BBBB
    }

    method b() {
        AAAA
        뭐하지???
        BBBB
    }
}

class B {

    method c() {
        AAAA
        뭐하지???
        BBBB
    }
}
```

공통적으로 하는 AAAA, BBBB를 변경이 있을 때 유지보수에 불편함이 있어서 관심사 분리가 가능한지 고민

## AOP 구현 방법
---

- 컴파일 A.java -> (AOP) -> A.class (AspectJ)
- 바이트코드 조작 A.java -> A.class -> (AOP) -> 메모리 (AspectJ)
- 프록시 패턴 (스프링 AOP)
