#!/usr/bin/env zsh
set -e

# Change this to the version you want
MAVEN_VERSION="3.9.11"

# Directory where Maven will be installed under your home
INSTALL_DIR="$HOME/.local/apache-maven-$MAVEN_VERSION"

# Temp download directory
TMPDIR="$(mktemp -d)"

echo "Downloading Maven version $MAVEN_VERSION ..."
cd "$TMPDIR"
wget "https://dlcdn.apache.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz"

echo "Extracting ..."
tar -xzf "apache-maven-$MAVEN_VERSION-bin.tar.gz"

echo "Moving to $INSTALL_DIR ..."
mkdir -p "$(dirname "$INSTALL_DIR")"
mv "apache-maven-$MAVEN_VERSION" "$INSTALL_DIR"

echo "Cleaning up ..."
cd ~
rm -rf "$TMPDIR"

# Set environment variables permanently for zsh
PROFILE_FILE="$HOME/.zshrc"

echo "Configuring environment in $PROFILE_FILE ..."

# Avoid duplicate entries
grep -qxF "### MAVEN (user) setup ###" "$PROFILE_FILE" || {
  cat >> "$PROFILE_FILE" <<EOF

### MAVEN (user) setup ###
export M2_HOME="\$HOME/.local/apache-maven-$MAVEN_VERSION"
export MAVEN_HOME="\$M2_HOME"
export PATH="\$M2_HOME/bin:\$PATH"
### end MAVEN setup ###
EOF
}

echo "Installation done. Run:"
echo "  source $PROFILE_FILE"
echo "Then verify with:"
echo "  mvn -version"

