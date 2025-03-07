# final_human_team2

## 프로젝트 개요

이 프로젝트는 GS25 스타일의 웹사이트를 구현하는 것을 목표로 합니다. Spring Boot와 Thymeleaf를 사용하여 GS25 웹사이트의 주요 페이지와 기능을 모방한 프로젝트입니다.

## 주요 기능
- 헤더, 메인 화면, 쿠퍼 섹션 구현
- 행사 상품 정보 제공
- 차별화 상품 정보 제공 (Youus 브랜드)

## 기술 스택
- **Java 21**: 최신 Java 기능을 활용한 객체 지향 개발
- **Spring Boot**: 웹 애플리케이션 프레임워크로 사용
- **Thymeleaf**: 서버 사이드 템플릿 엔진으로 사용
- **MySQL**: 데이터베이스 관리
- **Lombok**: 코드를 간결하게 작성하기 위해 사용

## 실행 방법
1. **빌드 환경 준비**
   - Java 21 이상 설치
   - Gradle 설치 또는 Wrapper 사용
2. **프로젝트 클론**
   ```sh
   git clone <레포지토리 주소>
   ```
3. **의존성 설치**
   ```sh
   ./gradlew build
   ```
4. **애플리케이션 실행**
   ```sh
   ./gradlew bootRun
   ```

## 프로젝트 구조
- `src/main/java` - 주요 Java 소스 코드
- `src/main/resources` - 정적 리소스 및 템플릿 파일
- `src/test` - 테스트 코드

## 기여 방법
- 이슈를 생성하고 기여하고 싶은 기능이나 버그 수정을 명확히 기재해주세요.
- PR(Pull Request)을 통해 기여 내용을 제출해주세요.

## 라이선스
Apache License 2.0