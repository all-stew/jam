#!/bin/bash

# 目标 Git 钩子目录
HOOKS_DIR="../.git/hooks"

# 新的 pre-commit 脚本位置
NEW_PRE_COMMIT="pre-commit"

# 确保钩子目录存在
if [ -d "$HOOKS_DIR" ]; then
    # 替换 pre-commit 钩子
    cp "$NEW_PRE_COMMIT" "$HOOKS_DIR/pre-commit"
    chmod +x "$HOOKS_DIR/pre-commit"
    echo "pre-commit 钩子已成功替换。"
else
    echo "错误：找不到 Git 钩子目录。请确保此脚本在 Git 仓库根目录下运行。"
fi
