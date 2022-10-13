package com.aspose.html.android.options;

import com.aspose.html.android.model.OutputFormats;

public class MarkdownConversionOptions implements ConversionOptions{

    public boolean useGit;

    public MarkdownConversionOptions setUseGit(boolean useGit)
    {
        this.useGit = useGit;
        return this;
    }
}
