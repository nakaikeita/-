・Todo   
作業前にこれから行う作業内容の記述、作業後に作業を行って出た課題、
また作業を行って難しかった事や理解できなかった点の解決方法を記述したファイル

・kinntai4  
eclispeで勤怠システムを作成したコード

kinntai4の構成  
kinntai4/src/main/java/model/Insert.java
DBに接続し、DBにID、出勤/退勤、出勤/退勤時間を格納する。

kinntai4/src/main/java/model/Itiranninfo.java  
Select.javaでDBから取得したデータを変数に格納する。

kinntai4/src/main/java/model/Select.java  
DBに接続し、DBの全てのデータを取得しリストに格納する。

kinntai4/src/main/java/servlet/AttendanceTimeCard.java  
syuttaikinn.jspからデータを取得し、Insert()を使い、Insert.javaにデータを送る。また、syuttaikin.jspにリクエストを転送している。

kinntai4/src/main/java/servlet/Itirann.java  
Select.javaで格納したリストを取得してセッションに格納する。また、kannrisya.jspにリクエストを転送している。

kinntai4/src/main/webapp/kannrisya.jsp  
ブラウザに管理者画面を表示。
itirann.javaでセッションに格納したリストを取得して表として表示。

kinntai4/src/main/webapp/syuttaikinn.jsp  
ブラウザにホーム画面（現在の日付と時刻、入力フォーム、出勤/退勤ボタン）を表示。
管理者画面に遷移するハイパーリンクを設置

kinntai4/src/main/webapp/style.css  
CSSを記述している。

・Java成果物作成  
勤怠システムの構成や画面の動きをまとめたPowerPoint



