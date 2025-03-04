## Change the app theme

### 디자인 및 색상
- **충분히 대비되는 색**을 사용해서 색상을 선택하는 것은 더 액세스하기 쉬운 앱을 빌드하는 방법 중 하나
- 투명도를 나타내는 알파 값
    -> 16진수 숫자 중 <u>첫 번째 숫자</u> (ARGB)
### 테마
: 앱, 활동 , 뷰 계층 구조 전체에 적용되는 스타일의 모음
>colors.xml 에서 16진수값으로 색상을 정의하고 , themes.xml에서는 colors.xml에 선언해둔 색상 리소스를 사용한다.
### 앱 테마 색상 선택하기
https://material.io/resources/color/#!/?view.left=0&view.right=0 
### 어두운 테마
### 요약
+ 머티리얼 색상 도구를 사용하여 앱 테마의 색상을 선택
+ 또는 머티리얼 팔레트 생성기를 사용하여 색상 팔레트를 선택
+ 리소스를 쉽게 재사용할 수 있도록 colors.xml 파일에 색상 리소스를 선언
+ 어두운 테마를 사용하면 전력 사용량을 줄일 수 있고 조명이 어두운 곳에서 앱을 쉽게 읽을 수 있다.
---
## Change the app icon

앱에 적응형 아이콘을 구현하면 앱에서 고화질 앱 아이콘을 적절하게 표시해서 다양한 기기를 수용할 수 있다.
>폴더 안보임 해결 : Project 창에서 Android-> Project로 변경하기

### 런처 아이콘
다양한 화면 밀도의 기기를 고려하려면 여러 버전의 앱 아이콘을 제공해야 한다.

### 적응형 아이콘
#### -포그라운드 및 백그라운드 레이어
- 개발자는 앱 아이콘을 **포그라운드 레이어와 백그라운드 레이어**로 구성할 수 있다.
#### -적응형 아이콘 파일 탐색
- 적응형 아이콘은 플랫폼의 API 수준 26에서 추가되었으므로 -v26 리소스 한정자가 있는 mipmap 리소스 디렉터리에서 적응형 아이콘을 선언해야 한다.
#### -벡터 드로어블과 비트맵 이미지
### 요약
+ 앱 아이콘 파일을 mipmap 리소스 디렉터리에 배치한다.
+ Android의 이전 버전과의 호환성을 위해 각 밀도 버킷(mdpi, hdpi, xhdpi, xxhdpi, xxxhdpi)에 다양한 버전의 앱 아이콘 비트맵 이미지를 제공한다.
+ 리소스 디렉터리에 리소스 한정자를 추가하여 특정 구성(예: v26)의 기기에서 사용해야 하는 리소스를 지정한다.
+ 벡터 드로어블은 Android의 벡터 그래픽 구현. 관련 색상 정보와 함께 일련의 점과 선, 곡선으로 XML에서 정의된다. 벡터 드로어블은 화질 저하 없이 어떤 밀도로도 조정할 수 있다.
+ 적응형 아이콘은 API 26에서 Android 플랫폼에 도입되었다. 특정 요구사항을 준수하는 포그라운드 및 백그라운드 레이어로 구성되므로 다양한 OEM 마스크가 적용된 여러 기기에서 앱 아이콘이 고화질로 표시된다.
+ Android 스튜디오에서 Image Asset Studio를 사용하여 앱의 레거시 및 적응형 아이콘을 만든다.
---
## Create a more polished user experience
### 머티리얼 구성요소
- 텍스트필드 Material : https://material.io/components/text-fields/android#filled-text-field
### 아이콘
- 화면 밀도에 맞는 여러 버전의 비트맵 이미지를 제공하는 대신 벡터 드로어블을 사용하는 것이 좋다.
- 아이콘 파일의 이름을 지정할 때는 접두어 **ic_**을 사용하는 것이 좋다.
### 스타일 및 테마
- res > values 에 styles.xml 만들기
### 요약
+ 가능하면 머티리얼 디자인 구성요소를 사용하여 머티리얼 디자인 가이드라인을 준수하고 더욱 다양하게 맞춤설정한다.
+ 아이콘을 추가하여 앱의 각 부분이 어떻게 작동하는지 시각적 힌트를 준다.
+ ConstraintLayout을 사용하여 레이아웃에 요소를 배치
+ 가장자리 사례(예: 가로 모드로 앱 회전하기)에서 앱을 테스트하고 해당되는 경우 개선
 
