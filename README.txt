・Attendance
Eclipseで勤怠システムを作成したコード

〇Attendanceの構成 
・Attendance/src/main/java/model/StampingInsert.java 
DBに接続し、DBにID、日付、出勤/退勤時間、労働時間、残業時間を格納する。

・Attendance/src/main/java/model/StampingSelect.java 
DBに接続し、DBから全てのデータを取得しリストに格納する。

・Attendance/src/main/java/model/StampingUpdate1.java 
DBに接続し、社員ID(12345)のユーザーの退勤時間、労働時間、残業時間を更新する。

・Attendance/src/main/java/model/StampingUpdate2.java 
DBに接続し、社員ID(23456)のユーザーの退勤時間、労働時間、残業時間を更新する。

・Attendance/src/main/java/model/StampingUpdate3.java 
DBに接続し、社員ID(34567)のユーザーの退勤時間、労働時間、残業時間を更新する。

・Attendance/src/main/java/model/StampingUpdate4.java 
DBに接続し、社員ID(45678)のユーザーの退勤時間、労働時間、残業時間を更新する。

・Attendance/src/main/java/model/StampingUpdate5.java 
DBに接続し、社員ID(56789)のユーザーの退勤時間、労働時間、残業時間を更新する。

・Attendance/src/main/java/model/UserInfo.java 
StampingSelect.javaでDBから取得したデータをそれぞれ変数に格納する。

・Attendance/src/main/java/servlet/EmployeeList.java 
StampingSelect.javaで格納したリストを取得後、新たなリストに社員ID毎のデータを格納しセッションに格納する。
また、employee.jspにリクエストを転送している。

・Attendance/src/main/java/servlet/EmployeeLoginServlet.java 
従業員画面にログインするサーブレット。指定のIDとパスワードが合致した場合にログイン処理を行う。
また、入力したIDとパスワードが間違っていた際のエラーメッセージをセッションに格納している。

・Attendance/src/main/java/servlet/ManagerList.java 
StampingSelect.javaで格納したリストを取得してセッションに格納する。
また、manager.jspにリクエストを転送している。

・Attendance/src/main/java/servlet/ManagerLoginServlet.java 
管理者画面にログインするサーブレット。指定のIDとパスワードが合致した場合にログイン処理を行う。
また、入力したIDとパスワードが間違っていた際のエラーメッセージをセッションに格納している。

・Attendance/src/main/java/servlet/StampingTimeCard.java 
社員ID毎で打刻時の日付、出勤時間、退勤時間、労働時間、残業時間のデータを取得し、StampingInsert.java、
StampingUpdate1.java、StampingUpdate2.java、StampingUpdate3.java、StampingUpdate4.java、
StampingUpdate5.javaにデータを転送している。
また、出勤を押さずに退勤を押した際とID、パスワードが異なっていた際のエラーメッセージを
セッションに格納している。

・Attendance/src/main/webapp/employee.jsp 
従業員画面。社員ID毎の打刻した日付、出勤時間、退勤時間、労働時間、残業時間を表示。

・Attendance/src/main/webapp/employeelogin.jsp 
従業員画面へ遷移するログイン画面。IDとパスワードを入力してログインする。

・Attendance/src/main/webapp/manager.jsp 
管理者画面。全社員の打刻した日付、出勤時間、退勤時間、労働時間、残業時間を表示。

・Attendance/src/main/webapp/managerlogin.jsp 
管理者画面へ遷移するログイン画面。IDとパスワードを入力してログインする。

・Attendance/src/main/webapp/stamping.jsp 
ホーム画面。現在の日付と時刻、IDとパスワードの入力フォーム、従業員画面と管理者画面へ遷移する
ハイパーリンクを設置している。

Attendance/src/main/webapp/style.css 
CSSを記述している。

Attendance/src/main/webapp/style2.css 
CSSを記述している。

・Todo 
作業前にこれから行う作業内容の記述、作業後に作業を行って発生した課題、また作業を行って難しかった事や理解できなかった点の解決方法を記述したファイル

・Java成果物作成 
勤怠システムの構成や画面の動きをまとめたPowerPoint
