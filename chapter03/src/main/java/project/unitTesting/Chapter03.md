# Chapter 03: 단위 테스트 구조

## 단위 테스트를 구성하는 방법

### 1. AAA (Given-When-Then) 패턴 사용
- **준비 (Given)**: 테스트 대상 시스템(SUT)과 해당 의존성을 원하는 상태로 설정합니다.
- **실행 (When)**: SUT의 메서드를 호출하며 준비된 의존성을 전달합니다.
- **검증 (Then)**: 결과를 검증합니다.

### 2. 여러 개의 준비, 실행, 검증 구절을 피하라
- **단일 실행 원칙**:
  - 실행 구절이 하나여야 테스트가 단순하고 빠르며 이해하기 쉬워집니다.
- **리팩토링 권장**:
  - 여러 실행과 검증이 포함된 테스트는 SUT의 API에 문제가 있다는 뜻으로 각 동작을 고유 테스트로 분리하라.

### 3. 테스트 내 `if` 문 피하기
- **문제점**:
  - 테스트가 너무 많은 것을 검증하고 있음을 나타냅니다.
- **해결책**:
  - 테스트를 여러 개로 나눠서 각각 특정 동작을 검증하게 해야한다.

### 4. 각 구절은 얼마나 커야 하는가?
- **실행 구절 경계**:
  - 실행 구절이 한 줄 이상인 경우를 조심해라.
  - 두 줄 이상일 경우, 캡슐화 위반이 있는지 확인해야 합니다.

### 5. 테스트 대상 시스템 명확히 하기
- **SUT 이름**:
  - 테스트 대상 시스템(SUT)은 `sut`라는 이름으로 명명하여 의존성과 구분해라.

---

## 테스트 간 테스트 픽스처 재사용

### 장점
- 테스트 코드의 양을 줄일 수 있습니다.
- 테스트에서 픽스처 구성을 대부분 제거할 수 있습니다.

### 단점
1. **테스트 간 결합도 증가**:
   - 픽스처 준비 로직을 수정하면 모든 테스트에 영향을 줄 수 있습니다.
2. **가독성 저하**:
   - 생성자를 통한 픽스처 재사용은 불확실성을 유발할 수 있습니다.

### 더 나은 재사용법
- **비공개 팩토리 메서드**:
  - 테스트 코드를 짧게 유지하면서 테스트의 전체 맥락을 유지할 수 있습니다.
- **예외**:
  - 데이터베이스 연결 등 모든 테스트에서 사용하는 픽스처는 생성자를 통해 인스턴스화할 수 있습니다.

---

## 단위 테스트 명명 지침

1. **테스트 이름에 메서드명을 포함하지 마라**:
   - 테스트는 애플리케이션의 동작을 검증해야 하며, 코드를 검증하는 것이 아닙니다.
   - 메서드 이름 변경 시 테스트 이름도 바꿔야 하는 결합도를 피해야 합니다.

2. **목표는 동작 검증**:
   - 구현 세부사항이 아니라 동작을 테스트하도록 초점을 맞추어라.

---

## 매개변수화된 테스트 리팩토링하기

1. **긍정적/부정적 테스트 케이스**:
   - 매개변수만으로 테스트 케이스를 판단할 수 있다면, 긍정적/부정적 테스트를 한 메서드로 작성해도 괜찮다.
   - 그렇지 않다면 긍정적 테스트를 도출하여 분리해야한다.

2. **복잡한 동작의 경우**:
   - 동작이 너무 복잡하다면 매개변수화된 테스트를 사용하지 말고, 테스트를 개별적으로 작성하는 것이 좋다.
