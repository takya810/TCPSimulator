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
