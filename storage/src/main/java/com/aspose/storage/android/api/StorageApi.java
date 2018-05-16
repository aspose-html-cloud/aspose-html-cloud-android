/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="StorageApi.java">
*   Copyright (c) 2018 Aspose.HTML for Cloud
* </copyright>
* <summary>
*   Permission is hereby granted, free of charge, to any person obtaining a copy
*  of this software and associated documentation files (the "Software"), to deal
*  in the Software without restriction, including without limitation the rights
*  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
*  copies of the Software, and to permit persons to whom the Software is
*  furnished to do so, subject to the following conditions:
*
*  The above copyright notice and this permission notice shall be included in all
*  copies or substantial portions of the Software.
*
*  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
*  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
*  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
*  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
*  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
*  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
*  SOFTWARE.
* </summary>
* --------------------------------------------------------------------------------------------------------------------
*/


package com.aspose.storage.android.api;

import com.aspose.storage.android.model.*;
import retrofit2.Call;
import retrofit2.http.*;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;


public interface StorageApi {
    /* FileApi */

    /**
     * Remove a specific file
     *
     * @param path      Path of the file including file name and extension e.g. /Folder1/file.ext (required)
     * @param versionId File&#39;s version (optional)
     * @param storage   User&#39;s storage name (optional)
     * @return Call&lt;RemoveFileResponse&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @DELETE("storage/file")
    Call<RemoveFileResponse> DeleteFile(
            @Query("path") String path,
            @Query("versionId") String versionId,
            @Query("storage") String storage
    );

    /**
     * Download a specific file
     *
     * @param path      Path of the file including the file name and extension e.g. /file.ext (required)
     * @param versionId File&#39;s version (optional)
     * @param storage   User&#39;s storage name (optional)
     * @return Call&lt;File&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("storage/file")
    Call<ResponseBody> GetDownload(
            @Query("path") String path,
            @Query("versionId") String versionId,
            @Query("storage") String storage
    );

    /**
     * Move a specific file
     *
     * @param src         Source file path e.g. /fileSource.ext (required)
     * @param dest        Destination file path e.g. /fileDestination.ext (required)
     * @param versionId   Source file&#39;s version, (optional)
     * @param storage     User&#39;s source storage name (optional)
     * @param destStorage User&#39;s destination storage name (optional)
     * @return Call&lt;MoveFileResponse&gt;
     */
    @POST("storage/file")
    Call<MoveFileResponse> PostMoveFile(
            @Query("src") String src,
            @Query("dest") String dest,
            @Query("versionId") String versionId,
            @Query("storage") String storage,
            @Query("destStorage") String destStorage
    );

    /**
     * Upload a specific file
     *
     * @param path      Path where to upload including filename and extension e.g. /file.ext or /Folder 1/file.ext (required)
     * @param file      File to upload (required)
     * @param versionId Source file&#39;s version (optional)
     * @param storage   User&#39;s storage name (optional)
     * @return Call&lt;File&gt;
     */
    @PUT("storage/file")
    Call<ResponseMessage> PutCreate(
            @Query("path") String path,
            @Body RequestBody file,
            @Query("versionId") String versionId,
            @Query("storage") String storage
    );

    /* FolderApi */

    /**
     * Remove a specific folder
     *
     * @param path      Folder path e.g. /Folder1 (required)
     * @param storage   User&#39;s storage name (optional)
     * @param recursive Remove recursivelly inner folder/files. If false and folder contains data than exception is raised. (optional, default to false)
     * @return Call&lt;RemoveFolderResponse&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @DELETE("storage/folder")
    Call<RemoveFolderResponse> DeleteFolder(
            @Query("path") String path,
            @Query("storage") String storage,
            @Query("recursive") Boolean recursive
    );

    /**
     * Get the file listing of a specific folder
     *
     * @param path    Start with name of storage e.g. root folder &#39;/&#39;or some folder &#39;/folder1/..&#39; (optional, default to /)
     * @param storage User&#39;s storage name (optional)
     * @return Call&lt;File&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("storage/folder")
    Call<ResponseBody> GetListFiles(
            @Query("path") String path,
            @Query("storage") String storage
    );

    /**
     * Move a specific folder
     *
     * @param src         Source folder path e.g. /Folder1 (required)
     * @param dest        Destination folder path e.g. /Folder2 (required)
     * @param storage     User&#39;s source storage name (optional)
     * @param destStorage User&#39;s destination storage name (optional)
     * @return Call&lt;MoveFolderResponse&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @POST("storage/folder")
    Call<MoveFolderResponse> PostMoveFolder(
            @Query("src") String src,
            @Query("dest") String dest,
            @Query("storage") String storage,
            @Query("destStorage") String destStorage
    );

    /**
     * Create the folder
     *
     * @param path        Target folder&#39;s path e.g. Folder1/Folder2/. The folders will be created recursively (required)
     * @param storage     User&#39;s source storage name (optional)
     * @param destStorage User&#39;s destination storage name (optional)
     * @return Call&lt;File&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @PUT("storage/folder")
    Call<ResponseMessage> PutCreateFolder(
            @Query("path") String path,
            @Query("storage") String storage,
            @Query("destStorage") String destStorage
    );

    /* StorageApi */

    /**
     * Check the disk usage of the current account
     *
     * @param storage User&#39;s storage name (optional)
     * @return Call&lt;DiscUsageResponse&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("storage/disc")
    Call<DiscUsageResponse> GetDiscUsage(
            @Query("storage") String storage
    );

    /**
     * Check if a specific file or folder exists
     *
     * @param path      File or folder path e.g. /file.ext or /Folder1 (required)
     * @param versionId File&#39;s version (optional)
     * @param storage   User&#39;s storage name (optional)
     * @return Call&lt;FileExistResponse&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("storage/exist")
    Call<FileExistResponse> GetIsExist(
            @Query("path") String path,
            @Query("versionId") String versionId,
            @Query("storage") String storage
    );

    /**
     * Check if storage exists
     *
     * @param name Storage name (required)
     * @return Call&lt;StorageExistResponse&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("storage/{name}/exist")
    Call<StorageExistResponse> GetIsStorageExist(
            @Path("name") String name
    );

    /**
     * Get the file&#39;s versions list
     *
     * @param path    File path e.g. /file.ext or /Folder1/file.ext (required)
     * @param storage User&#39;s storage name (optional)
     * @return Call&lt;FileVersionsResponse&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("storage/version")
    Call<FileVersionsResponse> GetListFileVersions(
            @Query("path") String path,
            @Query("storage") String storage
    );
}
