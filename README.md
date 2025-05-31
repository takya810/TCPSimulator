# TCPSimulator

このプロジェクトはJava 11およびSwingを利用し、クロスプラットフォーム（Windows/Mac）で動作するように構成されています。

## ビルド方法

- Java 11がインストールされている環境で、以下のコマンドでビルド・実行できます。

```
gradle build
```

- 実行例
```
gradle run
```

## クロスプラットフォーム対応について
- Java（特にSwing）は標準でWindows/Mac/Linuxに対応しています。
- OS依存のコードを避けることで、同じソースで複数OSに対応可能です。
- 配布用パッケージもGradleの`distZip`/`distTar`タスクで生成できます。

## Windows/Mac向け配布・ビルド

- Windows/Macどちらでも以下のコマンドで配布用パッケージ(zip/tar)を作成できます。

```
gradle distZip
gradle distTar
```

- 生成物は`build/distributions/`配下に出力されます。
  - Windows: zipファイル
  - Mac/Linux: tarファイル

- 配布先で解凍し、`bin/TCPSimulator`（Windowsは`bin/TCPSimulator.bat`）を実行してください。

## JRE同梱ネイティブ配布（jpackage）

- Java環境がインストールされていないPCでも実行できる配布物を作成できます。
- 以下のコマンドでJRE同梱のインストーラ・アプリ（macOS: .dmg, Windows: .exe など）を生成します。

```
gradle jpackage
```

- 生成物は`build/jpackage/`配下に出力されます。
- 例: `TCPSimulator-1.0.0.dmg`（macOSの場合）
- これを配布先でインストール・実行するだけで、Java環境不要でアプリが動作します。

> ※ jpackageの利用にはJDK 14以降が必要です。

## JRE同梱ネイティブ配布（JDK 11環境向け）

JDK 11ではjpackageが利用できないため、以下の外部ツールを利用してJRE同梱配布を行います。

### Windows向け: Launch4j
- https://launch4j.sourceforge.net/
- Javaアプリ（jar）をexe化し、JREも同梱可能。
- Launch4jのGUIまたはXML設定で、
  - `Main class`に `app.Main` を指定
  - `Bundled JRE path` に同梱JREディレクトリを指定
- exe生成後、JREと一緒に配布してください。

### Mac向け: AppBundler
- https://github.com/TheInfiniteKind/appbundler
- Javaアプリを.app形式にし、JREも同梱可能。
- AppBundlerの設定で
  - `mainclass`に `app.Main` を指定
  - `jre`に同梱JREディレクトリを指定
- .app生成後、JREと一緒に配布してください。

#### 共通事項
- JREはOpenJDK公式バイナリやAdoptium等から取得し、アプリと同じディレクトリに配置します。
- 詳細な設定例やスクリプトは各ツールの公式ドキュメントを参照してください。

> ※ JRE同梱配布はライセンスに注意してください。
