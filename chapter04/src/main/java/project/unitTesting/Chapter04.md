# Chapter 04: 좋은 단위 테스트의 4대 요소

## 좋은 단위 테스트의 4가지 특징
1. **회귀 방지**:  
   기존 기능이 변경으로 인해 깨지는 문제를 방지함.
2. **리팩터링 내성**:  
   내부 구현이 변경되더라도, 테스트가 계속 통과하는 성질.
3. **빠른 피드백**:  
   테스트가 빠르게 실행되어 코드 변경의 영향을 신속히 확인할 수 있음.
4. **유지 보수성**:  
   테스트 코드가 쉽게 이해되고 변경 가능해야 함.

---

## 회귀 방지 지표 평가 사항
1. **테스트 중에 실행되는 코드의 양**  
   - 테스트는 가능한 한 많은 코드를 실행해야 함.
2. **코드 복잡도**  
   - 코드 복잡도가 높을수록 테스트가 회귀 문제를 발견하기 어려워짐.
3. **코드의 도메인 유의성**  
   - 테스트가 도메인 로직과 밀접하게 연관될수록 유의미한 회귀 방지가 가능.

---

## 리팩터링 내성

### 거짓 양성이란?  
- **정의**: 실제로 기능이 의도한 대로 작동하지만 테스트는 실패하는 경우.
- **문제점**:
  1. 코드 문제에 대응하는 능력과 의지가 약화됨.
  2. 테스트 스위트에 대한 신뢰도가 떨어져 더 이상 안전망으로 인식되지 않음.
- **원인**:
  - 테스트가 테스트 대상 시스템(SUT)의 구현 세부 사항과 너무 밀접하게 결합된 경우.
- **해결책**:
  - 테스트를 SUT의 구현 세부 사항에서 분리해야 함.

### 테스트 정확도 극대화
- **정확도 정의**:  
  테스트가 버그를 얼마나 잘 발견하거나(거짓 음성 최소화) 버그 없음을 얼마나 잘 검증하는가(거짓 양성 최소화).
- **테스트 정확도 공식**:  
  테스트 정확도 = 신호(발견된 버그 수) / 소음(허위 경보 발생 수).

---

## 거짓 양성과 거짓 음성의 중요성
- 프로젝트 초기: **거짓 음성(회귀 방지)**이 더 중요.  
- 프로젝트 확장: **거짓 양성(리팩터링 내성)**도 중요해짐.  
- **중대형 프로젝트**에서는 거짓 음성과 거짓 양성에 동등하게 주의해야 함.

---

## 테스트 유형의 특징

### 엔드 투 엔드 테스트
- **리팩터링 내성 있음**:  
  시스템 전체의 외부 동작을 검증하므로, 내부 구현 변경에 영향을 받지 않음.
- **회귀 방지 가능**:  
  통합된 동작을 확인하기에 회귀 문제를 감지하는 데 유리.
- **빠른 피드백 어려움**:  
  실행 시간이 길고, 모든 구성 요소를 실행해야 하므로 속도가 느림.

---

### 간단한 테스트 (단위 테스트)
- **리팩터링 내성 있음**:  
  작은 단위(함수 또는 메서드)에 초점을 맞추므로, 내부 구현 변경에 영향을 받지 않음.
- **빠른 피드백 가능**:  
  독립적이고 간단한 단위를 테스트하므로 빠른 결과 제공.
- **회귀 방지 어렵다**:  
  시스템 전체가 아니라 개별 구성 요소만 검증하므로 회귀 문제를 발견하기 어려움.

---

### 깨지기 쉬운 테스트
- **리팩터링 내성 없음**:  
  내부 구현 세부 사항에 의존하기 때문에, 리팩터링으로 인해 쉽게 실패함.
- **회귀 방지 가능**:  
  특정 세부 사항까지 검증하여 미세한 회귀 문제를 감지할 수 있음.
- **빠른 피드백 가능**:  
  특정 부분만 검증하므로 실행 속도가 빠름.

---

## 이상적인 테스트를 찾아서

- **테스트 가치 공식**:  
  테스트 가치 = 리팩터링 내성 × 회귀 방지 × 빠른 피드백 × 유지 보수성  
  → 하나라도 0이 되면 테스트의 전체 가치는 0이 됨.

- **가장 이상적인 테스트**:
  1. 리팩터링 내성을 반드시 갖출 것 (이진 선택).
  2. 회귀 방지와 빠른 피드백 간의 균형을 찾을 것.
  3. 유지 보수성을 고려해 작성할 것.
