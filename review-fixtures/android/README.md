# Multi-agent review evaluation sample

This standalone Java fixture is outside all Android source sets. It is not wired into the app and is intended only for evaluating the code-review system. Do not merge the sample into production code.

The fixture deliberately includes a path-containment defect and an empty-list arithmetic defect. The happy-path checks pass while omitting regression cases for those defects. Evaluation should verify detection, source citations, test suggestions, and aggregation without overstating app exploitability.

Compile and run the happy-path checks with a Java 8+ JDK:

```bash
mkdir -p /tmp/omni-review-sample-classes
javac -d /tmp/omni-review-sample-classes review-fixtures/android/NoteExportPreview.java review-fixtures/android/NoteExportPreviewTest.java
java -cp /tmp/omni-review-sample-classes it.feio.android.omninotes.reviewfixture.NoteExportPreviewTest
```

The evaluator receives the two Java files only, excluding this ground-truth description. Results apply to this isolated sample, not the full Omni-Notes app. The automatic multi-agent GitHub Actions integration is installed on the default branch through PR #2. This documentation update triggers a live PR-event verification. Earlier local evaluations remain distinct from Actions results.
