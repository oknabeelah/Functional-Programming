13/10/2026
### Installing and setting up Calva

**1: Install Java**
Clojure runs on the Java Virtual Machine, so install a Java Development Kit first.
Recommended option: [Eclipse Temurin JDK](https://adoptium.net/temurin/releases/)
Install the Windows x64 JDK and ensure Java is added to the Windows `PATH`. Verify with `java -version`.

**2: Install the Clojure CLI**
Follow the official installation instructions: - [Install Clojure](https://clojure.org/guides/install_clojure)
On Windows, the Clojure installer provides the `clj` and `clojure` commands.
Verify with `clj -Sdescribe` or `clj -version`

**3: Ensure windows path is correct**
```bash
C:\Windows\System32
C:\Windows
C:\Windows\System32\Wbem
C:\Windows\System32\WindowsPowerShell\v1.0
C:\Program Files\Git\cmd
C:\Users\<username>\AppData\Local\Apps\clojure
```

**4: Install Calva extension in VSCode**
- [Calva extension](https://marketplace.visualstudio.com/items?itemName=betterthantomorrow.calva)

**5: Install the Clojure language server**
Calva uses `clojure-lsp` for editor features. Normally, Calva can install it automatically. From VS Code:
```bash 
Ctrl+Shift+P
Calva: Install clojure-lsp
```
If the automatic download fails, download the Windows binary manually from: [Clojure LSP releases](https://github.com/clojure-lsp/clojure-lsp/releases/latest)
Download the Windows executable and configure Calva to use it.
```shell
{
  "calva.clojureLspPath": "C:\\Users\<path-to-clojure-exe>\clojure-lsp.exe"
}
```

Then do:
```
Developer: Reload Window
Calva: Restart Language Server
```

You can also verify the binary directly
```
/c/Users/<path-to-clojure-exe>/clojure-lsp.exe" --version
```

**7: Create a new Clojure project**
The `deps-new` tool can generate a project structure.
Install it once: `clj -Ttools install-latest :lib io.github.seancorfield/deps-new :as new`
This installs the `new` tool alias. To create a new application project:
```
cd ~/Documents
clj -Tnew create :template app :name <folder-name>
```

