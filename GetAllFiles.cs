using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Util.Exceptions;

namespace Util
{
    public class GetAllFiles
    {
        private List<string> files;

        public GetAllFiles()
        {
            //init list
            files = new List<string>();
        }

        /// <summary>
        /// getFiles returns a generic list of file paths
        /// </summary>
        /// <param name="path"></param>
        /// <exception cref="UtilException"></exception>
        /// <returns>List</returns>
        public List<string> getFiles(string path)
        {
            
            try
            {
                foreach (string f in Directory.GetFiles(path))
                {
                    files.Add(f);
                }
                foreach (string d in Directory.GetDirectories(path))
                {
                    getFiles(d);
                }
            }
            catch (Exception ex)
            {
                throw new UtilException(ex.Message);
            }

            return files;
        }
        
    }
}
