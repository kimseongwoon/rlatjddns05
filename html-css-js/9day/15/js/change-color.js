// vanilla형식으로 자바스크립트 코드 만들기
let heading = document.querySelector('#heading');  // id가 heading인 태그 정보 가져오기
// id가 heading인 객체가 있고 그것을 마우스로 클릭을 했을 경우 동작
heading.onclick = function() {
  heading.style.color = "red";  // heading객체의 폰트색깔을 빨간색 변환 
}