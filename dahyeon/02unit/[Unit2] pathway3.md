## RecyclerView를 사용하여 스크롤 가능한 목록 표시

### 데이터 목록 설정하기
- 예를 들어 strings.xml 파일이 아래와 같다면  
```kotlin
<resources>
<string name="affirmation1">I am strong.</string>
</resources>
```
R.string.affirmation1으로 참조 가능
### 요약
+ RecyclerView 위젯을 사용하여 데이터 목록을 표시할 수 있다.
+ RecyclerView는 어댑터 패턴을 사용하여 데이터를 조정하고 표시한다.
+ ViewHolder는 RecyclerView의 뷰를 만들고 보유한다.
+ RecyclerView는 내장된 LayoutManagers와 함께 제공된다. RecyclerView는 항목을 배치하는 방식을 LayoutManagers에 위임한다.
+ 어댑터 구현은 다음을 따른다.
    + 어댑터의 새 클래스(예: ItemAdapter)를 만듭니다.
    + 단일 목록 항목 뷰를 나타내는 맞춤 ViewHolder 클래스를 만듭니다. RecyclerView.ViewHolder 클래스에서 확장합니다.
    + ItemAdapter 클래스를 수정하여 RecyclerView.Adapter 클래스에서 확장합니다(맞춤 ViewHolder 클래스 사용).
    + 어댑터 내에서 getItemsCount(), onCreateViewHolder(), onBindViewHolder() 메서드를 구현합니다.
  
## 카드를 사용하여 이미지 목록 표시

### 요약
+ RecyclerView에 추가 콘텐츠를 표시하려면 기본 데이터 모델 클래스와 데이터 소스를 수정합니다. 그런 다음, 목록 항목 레이아웃 및 어댑터를 업데이트하여 데이터를 뷰에 설정합니다.
+ 리소스 주석을 사용하여 올바른 유형의 리소스 ID가 클래스 생성자에 전달되도록 합니다.
+ Android 라이브러리의 머티리얼 구성요소를 사용하여 더 간편하게 앱이 권장 머티리얼 디자인 가이드라인을 준수하도록 합니다.
+ MaterialCardView를 사용하여 머티리얼 카드에 콘텐츠를 표시합니다.
+ 색상 및 간격의 측면에서 앱을 시각적으로 조금만 수정하면 앱이 더욱 세련되고 일관되게 보이도록 할 수 있습니다.
