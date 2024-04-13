# jam

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=all-stew_jam&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=all-stew_jam)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=all-stew_jam&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=all-stew_jam)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=all-stew_jam&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=all-stew_jam)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=all-stew_jam&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=all-stew_jam)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=all-stew_jam&metric=bugs)](https://sonarcloud.io/summary/new_code?id=all-stew_jam)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=all-stew_jam&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=all-stew_jam)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=all-stew_jam&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=all-stew_jam)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=all-stew_jam&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=all-stew_jam)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=all-stew_jam&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=all-stew_jam)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=all-stew_jam&metric=coverage)](https://sonarcloud.io/summary/new_code?id=all-stew_jam)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=all-stew_jam&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=all-stew_jam)

## 1 开发须知

### 1.1 如何构建本地环境

### 1.2 如何使用checkstyle

### 1.3 更新pre-commit

```shell
cd .sh
./replace-pre-commit.sh
```

### 1.4 如何使用subtree构建proto

```shell
# 初始化
git subtree add --prefix=proto https://github.com/all-stew/proto feat --squash
# 拉取
git subtree pull  --prefix=proto https://github.com/all-stew/proto feat --squash
# 推到远端
git subtree push --prefix=proto https://github.com/all-stew/proto feat
```
